//
//  Scanner.swift
//  iosApp
//
//  Created by Andrey Orel on 29.1.24..
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import BarcodeScanner

class ScannerImpl: IosScanner {
	let parent: UIViewController
	let scanner: BarcodeScannerViewController = BarcodeScannerViewController()
	let callback: ScannerCallback

	required init(
		parent: UIViewController,
		callback: ScannerCallback
	) {
		self.callback = callback
		self.parent = parent
		scanner.codeDelegate = self
		scanner.dismissalDelegate = self
	}

	func launch() {
		parent.present(scanner, animated: true, completion: nil)
	}
}

// MARK: - BarcodeScannerCodeDelegate

extension ScannerImpl: BarcodeScannerCodeDelegate {
	func scanner(_ controller: BarcodeScannerViewController, didCaptureCode code: String, type: String) {
		callback.onCodeScanned(code: code)
		DispatchQueue.main.asyncAfter(deadline: .now() + 5.0) {
			controller.resetWithError()
		}
	}
}

// MARK: - BarcodeScannerDismissalDelegate

extension ScannerImpl: BarcodeScannerDismissalDelegate {
	func scannerDidDismiss(_ controller: BarcodeScannerViewController) {
		callback.onDismiss()
		controller.dismiss(animated: true, completion: nil)
	}
}

class ScannerFactoryImpl: ScannerFactory {
	let parent: UIViewController

	required init(
		parent: UIViewController
	) {
		self.parent = parent
	}

	func create(callback: ScannerCallback) -> IosScanner {
		ScannerImpl(parent: parent, callback: callback)
	}
}
