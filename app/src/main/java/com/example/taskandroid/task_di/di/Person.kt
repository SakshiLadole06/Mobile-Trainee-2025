package com.example.taskandroid.task_di.di

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

interface Person {
    fun educationImpl()
    fun jobImpl()
}

//binds Annotation
class PersonClassBinds @Inject constructor():Person{
    override fun educationImpl() {
        Log.d("DI","(Binds)Education fun is calling...")
    }
    override fun jobImpl() {
        Log.d("DI","(Binds)Job fun is calling...")
    }
}

//Provides annotation
class PersonClassProvides @Inject constructor():Person{
    override fun educationImpl() {
        Log.d("DI","(Provides)Education fun is calling...")
    }
    override fun jobImpl() {
        Log.d("DI","(Provides)Job fun is calling...")
    }
}

//When you use Binds then you need to use abstract class
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule{
    @Binds
    abstract fun appModule(pcb:PersonClassBinds):Person
}

//When you use Provides then not necceseery that you only use perticular class or objext
//you can use singleton object, object , normal class
@Module
@InstallIn(SingletonComponent::class)
object AppModuleObject{
    @Provides
    @Singleton
    fun appModule(pcp:PersonClassProvides):Person{
        return pcp
    }
}