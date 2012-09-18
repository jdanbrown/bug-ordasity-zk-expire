package bug

import com.boundary.ordasity
import com.codahale.logula.Logging
import com.twitter.common.zookeeper.ZooKeeperClient

object Bug extends App {

  // Route java.util.logging through slf4j
  org.slf4j.bridge.SLF4JBridgeHandler.removeHandlersForRootLogger
  org.slf4j.bridge.SLF4JBridgeHandler.install

  new Bug().start
  synchronized { wait }

}

class Bug extends ordasity.ClusterListener with Logging {

  def onJoin(_zk: ZooKeeperClient) { log.info("Joined cluster") }
  def onLeave                      { log.info("Left cluster") }
  def startWork(work: String)      {}
  def shutdownWork(work: String)   {}

  def start {
    cluster.join()
  }

  val cluster = new ordasity.Cluster("bug", this, (new ordasity.ClusterConfig
    setHosts             "localhost:2190"
    setNodeId            "node-0"
    setWorkUnitShortName "work"
    setWorkUnitName      "bug/work"
  ))

}
