package mbk.io.lovecalc2

import android.content.SharedPreferences
import  android.util.Log
import androidx.lifecycle.MutableLiveData
import mbk.io.lovecalc2.model.LoveApi
import mbk.io.lovecalc2.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: LoveApi,
    private val sharedPreferences: SharedPreferences,
) {
    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val mutableLiveData = MutableLiveData<LoveModel>()
        api.getLovePerc(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        response.body()?.let { loveModel ->
                            mutableLiveData.postValue(loveModel)
                        }
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message} ")
                }
            })
        return mutableLiveData
    }

    fun hasOnboardingBeenShown(): Boolean {
        return sharedPreferences.getBoolean("onboarding_shown", false)
    }

    fun setOnboardingShown() {
        sharedPreferences.edit().putBoolean("onboarding_shown", true).apply()
    }
}
