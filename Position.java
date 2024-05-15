package TheLondonTube;

public interface Position<E> {
  E getElement() throws IllegalStateException;
}
