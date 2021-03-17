package com.example.actionapp.presenter

import com.example.actionapp.module.Action
import com.example.actionapp.view.BaseView

interface ActionContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onActionButtonTapped()
    }

    interface View : BaseView<Presenter> {
        fun performAction(actions: Array<Action>)
        fun displayContactsList()
        fun displaySimpleToast()
        fun displayNotification()
        fun animateActionButton()
    }
}