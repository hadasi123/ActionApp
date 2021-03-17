package com.example.actionapp.di

import com.example.actionapp.module.ActionsRepository

interface DependencyInjector {
    fun actionsRepository() : ActionsRepository

}