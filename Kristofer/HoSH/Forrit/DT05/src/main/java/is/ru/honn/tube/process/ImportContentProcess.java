package is.ru.honn.tube.process;

import is.ruframework.process.RuAbstractProcess;

import java.util.logging.Logger;

/**
 * Created by kristofer on 9/16/15.
 */
public class ImportContentProcess extends RuAbstractProcess {
    private Logger log = Logger.getLogger(ImportContentProcess.class.getName());

    public ImportContentProcess() {

    }

    @Override
    public void beforeProcess() {
        log.info("beforeProcess");
    }

    @Override
    public void startProcess() {
        log.info("startProcess");
    }

    @Override
    public void afterProcess() {
        log.info("afterProcess");
    }
}
