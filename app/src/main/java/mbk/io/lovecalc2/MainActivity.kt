package mbk.io.lovecalc2


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import mbk.io.lovecalc2.databinding.ActivityMainBinding
import mbk.io.lovecalc2.onboarding.OnBoardingFragment
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var utils: Utils

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var repository: Repository

    private val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!repository.hasOnboardingBeenShown()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.viewPager, OnBoardingFragment())
                .commit()
            repository.setOnboardingShown()
        }
        initClickers()
    }


    private fun initClickers() {
        with(binding) {
            historyBtn.setOnClickListener {
                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            }
            binding.getBtn.setOnClickListener {
                val editor = sharedPreferences.edit()
                editor.putBoolean("as", true)
                editor.apply()

                utils.showToast(this@MainActivity)

                viewModel.getLoveLiveData(
                    binding.firstEd.text.toString(),
                    binding.secondEd.text.toString()
                ).observe(this@MainActivity, Observer {
                    App.appDatabase.getDoa().insert(it)
                    binding.resultTv.text = it.toString()
                })
            }
        }

    }


}