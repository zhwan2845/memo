package ddwuumc.com.mobile.memo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ddwuumc.com.mobile.memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var editTextMemo: EditText
    private var savedMemo: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editTextMemo = findViewById(R.id.editTextMemo)
        val btnNext: Button = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {
            val intent = Intent(this, ConfirmActivity::class.java).apply {
                putExtra("memo", editTextMemo.text.toString())
            }
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // onPause에서 저장한 내용으로 EditText를 설정
        if (!savedMemo.isNullOrEmpty()) {
            editTextMemo.setText(savedMemo)
        }
    }

    override fun onPause() {
        super.onPause()
        // 현재 EditText 내용을 전역 변수에 저장
        savedMemo = editTextMemo.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        // 다시 작성할지 묻는 Dialog 표시
        AlertDialog.Builder(this).apply {
            setTitle("확인")
            setMessage("다시 작성하시겠습니까?")
            setPositiveButton("예") { _, _ ->
                // 계속 작성
            }
            setNegativeButton("아니오") { _, _ ->
                // 저장했던 내용 비우기
                savedMemo = null
                editTextMemo.setText("")
            }
            show()
        }
    }
}