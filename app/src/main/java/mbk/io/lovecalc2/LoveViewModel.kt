package mbk.io.lovecalc2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mbk.io.lovecalc2.model.LoveModel
import javax.inject.Inject
@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getLoveLiveData(firstName: String,second: String): LiveData<LoveModel> {
        return repository.getData(firstName,second)
    }
}