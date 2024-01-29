import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
		MainComposeView()
	}
}

struct MainComposeView: UIViewControllerRepresentable {

	var viewController: UIViewController = AppViewController().get()

	func makeUIViewController(context: Context) -> UIViewController {
		AppViewController().bindScannerFactory(factory: ScannerFactoryImpl(parent: viewController))
		AppViewController().startKoin()
		return viewController
	}

	func updateUIViewController(_ uiViewController: UIViewController,
								context: Context) {
	}

	func create(callback: ScannerCallback) -> IosScanner {
		ScannerImpl(parent: viewController, callback: callback)
	}
}
