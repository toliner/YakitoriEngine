package toliner.yakitori.tick

abstract class AbstractTickManager : ITickManager {

    protected abstract val workers: MutableList<ITickWorker>
    override var tps = 0f
    protected set

    override fun addWorker(worker: ITickWorker) {
        workers.add(worker)
    }

    override fun removeWorker(worker: ITickWorker): Boolean {
        return workers.remove(worker)
    }

    override fun workerContains(worker: ITickWorker): Boolean {
        return workers.contains(worker)
    }

    override operator fun plusAssign(worker: ITickWorker) {
        addWorker(worker)
    }

    override operator fun minusAssign(worker: ITickWorker) {
        removeWorker(worker)
    }

}