package com.dev.coding.repository.auth
import android.support.di.Inject
import android.support.di.ShareScope
import com.dev.coding.datasource.local.UserLocalSource

@Inject(ShareScope.Fragment)
class LogoutRepo(private val userLocalSource: UserLocalSource) {
		operator fun invoke() {
				userLocalSource.clearToken()
		}
}