package project;

import java.util.List;
import java.util.Queue;

public interface ISiralayici {
    void sirala(Queue<Process> kuyruk);

	void sirala(List<Process> prosesler);
}
