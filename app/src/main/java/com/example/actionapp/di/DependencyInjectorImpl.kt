package com.example.actionapp.di

import com.example.actionapp.module.ActionsRepository
import com.example.actionapp.module.ActionsRepositoryImpl

class DependencyInjectorImpl : DependencyInjector {
    override fun actionsRepository() : ActionsRepository {
        return ActionsRepositoryImpl()
    }
}