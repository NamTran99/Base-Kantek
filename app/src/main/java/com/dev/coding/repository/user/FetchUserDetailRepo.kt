package com.dev.coding.repository.user
import android.support.core.livedata.post
import android.support.di.Inject
import android.support.di.ShareScope
import androidx.lifecycle.MutableLiveData
import com.dev.coding.datasource.local.UserLocalSource
import com.dev.coding.factory.UserFactory
import com.dev.coding.model.ui.IUserDetails

@Inject(ShareScope.Fragment)
class FetchUserDetailRepo(
		private val userLocalSource: UserLocalSource,
		private val userFactory: UserFactory
) {
		val result = MutableLiveData<IUserDetails>()
		
		suspend operator fun invoke(email: String) {
				val user = userLocalSource.findByEmail(email)
						?: error("Not found user by email $email ")
				result.post(userFactory.createDetail(user))
		}
}