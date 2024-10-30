package ddwuumc.com.mobile.memo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ddwuumc.com.mobile.memo.databinding.ActivityConfirmBinding

class ConfirmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvMemo: TextView = findViewById(R.id.tvMemo)
        val memo = intent.getStringExtra("memo")
        tvMemo.text = memo
    }
}