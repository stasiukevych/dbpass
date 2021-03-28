package controller.password;

public class DBPassController implements PassController {
  @Override
  public boolean isPossible(String pass) {
    return pass.length() >= 25;
  }
}
