package mbk.io.lovecalc2.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import mbk.io.lovecalc2.databinding.ItemOnboardingBinding
import mbk.io.lovecalc2.model.OnboardingData


class OnBoardingAdapter(
    private val onClick: FragmentManager,
) : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf<OnboardingData>(
        OnboardingData(
            "https://mir-s3-cdn-cf.behance.net/project_modules/disp/543dc3137835703.621276226e402.jpg",
            "Fresh food",
            "Lorem impsum dolor sit amet, consectetuer adipiscing elit.Aenean commodo ligula eget dolor"
        ),
        OnboardingData(
            "https://mir-s3-cdn-cf.behance.net/project_modules/disp/a61635137835703.6212762270a28.jpg",
            "Fresh food",
            "Lorem impsum dolor sit amet, consectetuer adipiscing elit.Aenean commodo ligula eget dolor"
        ),
        OnboardingData(
            "https://mir-s3-cdn-cf.behance.net/project_modules/disp/d5b8f9137835703.621276226fb5c.jpg",
            "Easy Payment",
            "Lorem impsum dolor sit amet, consectetuer adipiscing elit.Aenean commodo ligula eget dolor"
        ),
        OnboardingData(
            "https://mir-s3-cdn-cf.behance.net/project_modules/disp/d5b8f9137835703.621276226fb5c.jpg",
            "Easy Payment",
            "Lorem impsum dolor sit amet, consectetuer adipiscing elit.Aenean commodo ligula eget dolor"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        val binding = ItemOnboardingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OnBoardingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {

        fun bind(boarding: OnboardingData) {
            binding.title.text = boarding.title
            binding.desc.text = boarding.desc
            boarding.animationUrl?.let { binding.ivBoard.setAnimation(it) }
            binding.btnStart.isVisible = adapterPosition == list.lastIndex
            binding.btnStart.setOnClickListener { onClick }
        }
    }
}