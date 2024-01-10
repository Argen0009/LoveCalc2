package mbk.io.lovecalc2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mbk.io.lovecalc2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun showDataInAlphabeticalOrder() {
        val list = App.appDatabase.getDoa().getAllInAlphabeticalOrder()
        val formattedText = list.joinToString(separator = "", prefix = "")
        binding.historyTv.text = formattedText
    }

    override fun onResume() {
        super.onResume()
        showDataInAlphabeticalOrder()
    }

    private fun showDataSortedBy(columnName: String) {
        val list = App.appDatabase.getDoa().getAllSorted(columnName)
        val formattedText = list.joinToString(separator = "", prefix = "")
        binding.historyTv.text = formattedText
    }

    private fun sortBy(columnName: String) {
        showDataSortedBy(columnName)
    }

}