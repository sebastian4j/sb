package cl.sebastian.uno;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
  private final TransaccionRollback ar;
  private final TransaccionNoRollback br;

  public DevBootstrap(final TransaccionRollback br, final TransaccionNoRollback ar) {
    this.ar = br;
    this.br = ar;
  }

  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) {
    try {
      ar.trx();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    br.trx();
  }
}
