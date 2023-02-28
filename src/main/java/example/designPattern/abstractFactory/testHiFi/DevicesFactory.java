package example.designPattern.abstractFactory.testHiFi;

/**
 * @author apetazzi
 *
 *         AbstractFactory: interfaccia DevicesFactory.
 *
 *         Dichiara una interfaccia per le operazioni che creano e restituiscono
 *         gli oggetti (prodotti) da testare e/o da usare per il test.
 *
 *         Nella dichiarazione di ogni metodo, i prodotti restituiti sono dei
 *         tipi AbstractProduct cioe' le interfacce player, Recorder e Media,
 *         non i relativi tipi concreti.
 *
 */
public interface DevicesFactory {

	/**
	 * @return TODO
	 *
	 */
	Player createPlayer();

	/**
	 *
	 */
	example.designPattern.abstractFactory.testHiFi.Recorder createRecorder();

	/**
	 *
	 */
	example.designPattern.abstractFactory.testHiFi.Media createMedia();
}
