package com.example.actionapp.presenter

import com.example.actionapp.di.DependencyInjector
import com.example.actionapp.module.ActionsRepository

class ActionPresenter (view: ActionContract.View,
                       dependencyInjector: DependencyInjector
) : ActionContract.Presenter {

    private val actionsRepository: ActionsRepository = dependencyInjector.actionsRepository()

    private var view: ActionContract.View? = view

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        loadActions()
    }

    override fun onActionButtonTapped() {
        TODO("Not yet implemented")
    }

    private fun loadActions()
    {
        val actions = actionsRepository.loadActions()
        view?.performAction(actions)
    }
}