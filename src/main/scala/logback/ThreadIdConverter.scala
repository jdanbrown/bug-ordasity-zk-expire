package logback

import ch.qos.logback.classic.pattern.ClassicConverter
import ch.qos.logback.classic.spi.ILoggingEvent

class ThreadIdConverter extends ClassicConverter {
  def convert(event: ILoggingEvent): String = Thread.currentThread.getId.toString
}
