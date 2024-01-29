package com.aendgrleey.lovicashbacktest.app

import androidx.compose.ui.window.ComposeUIViewController
import com.aendgrleey.lovicashbacktest.scanner.presentation.scanner.ScannerFactory
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object AppViewController {

	private var scannerModule: Module? = null
	fun bindScannerFactory(factory: ScannerFactory) {
		scannerModule = module { single { factory } }
	}

	fun startKoin() {
		startKoin {
			modules(scannerModule ?: error("no scanner module bound"))
			modules(appModule)
		}
	}

	fun get() = ComposeUIViewController { App() }
}