package com.example.mymusic.ui.presentation.home

import com.example.mymusic.domain.model.Chart

/**
 * Created by ManhalKhwashki on 3/16/2024.
 */
data class HomeActivityState(
    val chart: Chart? =null,
    val isLoading: Boolean = false,

    )