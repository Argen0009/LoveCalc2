package mbk.io.lovecalc2.onboarding

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mbk.io.lovecalc2.databinding.FragmentOnBoarding2Binding
import me.relex.circleindicator.CircleIndicator3
import javax.inject.Inject

class onBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoarding2Binding

    private lateinit var onBoardingAdapter: OnBoardingAdapter

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOnBoarding2Binding.inflate(inflater,null,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBoardingAdapter = OnBoardingAdapter(childFragmentManager)
        binding.viewPager.adapter = onBoardingAdapter

        val indicator: CircleIndicator3 = binding.indicator2
        indicator.setViewPager(binding.viewPager)
        sharedPreferences.edit().putBoolean("onboarding_shown",true).apply()
    }

}