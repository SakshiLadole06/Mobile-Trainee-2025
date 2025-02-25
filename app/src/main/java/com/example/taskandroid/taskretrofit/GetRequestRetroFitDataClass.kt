//data class for the store data which get from api and then show
package com.example.taskandroid.taskretrofit

data class RetroFitDataClass(
    val name:String,
    val company:CompanyRetroFitDataclass
)
data class CompanyRetroFitDataclass(
    val name : String
)