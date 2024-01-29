package com.aendgrleey.lovicashbacktest.scanner.di

import com.aendgrleey.lovicashbacktest.scanner.presentation.ScannerScreenModel
import org.koin.dsl.module

val scannerModule = module {
    factory { ScannerScreenModel() }
}