package com.example.obivious.di

import com.example.obivious.repo.ShowListRepository
import com.example.obivious.repo.ShowListRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val repoModule = module {
    single { ShowListRepositoryImpl(get(), get(), get()) } bind ShowListRepository::class
}