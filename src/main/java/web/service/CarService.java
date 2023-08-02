package web.service;

import org.springframework.ui.Model;

public interface CarService {
     String getCars(int count, Model model);
}
