package com.example.summmary7.data.network.models

data class Summary(
    val actionTime: String,
    val team1Action: List<Team1Action>,
    val team2Action: List<Team2Action>
)