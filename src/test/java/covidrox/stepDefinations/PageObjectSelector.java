package covidrox.stepDefinations;

public interface PageObjectSelector {

    void LoginWithCredentials(String userName,String password);
    boolean isSuccessLogin();
    void EnterOnlyUserName(String userName);
    boolean isSubmitButtonEnabled();
}
