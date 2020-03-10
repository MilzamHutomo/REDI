package com.project.relawanmengabdi

object VacancyData {

    private val vcnName = arrayOf(
        "Asian Games 2018",
        "Piala Presiden 2020",
        "FIFA World Cup",
        "Tokyo Olimpiade 2020",
        "Invention Udayana",
        "Kaderisasi"
    )

    private val vcnLocation = arrayOf(
        "Jakarta-Palembang",
        "Jakarta",
        "Mainland China",
        "Tokyo, Japan",
        "Bali",
        "Universitas Pertamina"
    )

    private val vcnDuration = arrayOf(
        "18 August - 18 September",
        "To Be Announced",
        "After Corona Virus Ended",
        "Running at the moment",
        "April 2020",
        "Maret - April 2020"
    )

    val listData: ArrayList< Vacancy > get() {
        val list = arrayListOf< Vacancy >()
        for ( index in vcnName.indices ){
            val data = Vacancy()
            data.name = vcnName[ index ]
            data.location = vcnLocation[ index ]
            data.duration = vcnDuration[ index ]
            list.add( data )
        }
        return list
    }
}