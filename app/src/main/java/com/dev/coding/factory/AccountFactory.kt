package com.dev.coding.factory
import android.support.di.Inject
import android.support.di.ShareScope
import com.dev.coding.model.entity.AccountEntity
import com.dev.coding.model.ui.LoginForm

@Inject(ShareScope.Activity)
class AccountFactory {

    fun createForm(account: AccountEntity?): LoginForm {
        if (account != null)
            return LoginForm(account.email, account.password, true)
        return LoginForm()
    }
}