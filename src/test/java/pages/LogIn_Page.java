package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LogIn_Page {
    public LogIn_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement firstLoginButton;

    @FindBy(id = "UserName")
    public WebElement usernameBox;

    @FindBy(id = "Password")
    public WebElement passwordBox;

    @FindBy(id = "btnSubmit")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement validationErrorText;

    @FindBy(linkText = "Create a new account")
    public WebElement createNewAccButton;

    @FindBy(linkText = "Home")
    public WebElement homeButton;

    @FindBy(linkText = "Rooms")
    public WebElement rooms;

    @FindBy(linkText = "Restaurant")
    public WebElement restaurant;

    @FindBy(linkText = "About")
    public WebElement about;

    @FindBy(linkText = "Blog")
    public WebElement blog;

    @FindBy(linkText = "Contact")
    public WebElement contact;

    @FindBy(linkText = "Concort Hotel")
    public WebElement concortHotelButton;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelList;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoom;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotel;

    @FindBy(id = "Code")
    public WebElement addHotelCode;

    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement addHotelIdDdown;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement addHotelSaveButton;

    @FindBy(xpath = "//div[text()='Hotel was inserted successfully']")
    public WebElement addHotelSuccessfullySaveText;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement addHotelLastOk;

    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addHotelroom;

    @FindBy(xpath = "//select[@id='IDHotel']")
    public WebElement addHotelroomIdDdown;

    @FindBy(xpath = "//input[@title='Code']")
    public WebElement addHotelroomCode;

    @FindBy(xpath = "//input[@id='Price']")
    public WebElement addHotelroomPrice;

    @FindBy(xpath = "//a[.='400 ']")
    public WebElement addHotelroom400;

    @FindBy(xpath = "//select[@id='IDGroupRoomType']")
    public WebElement addHotelroomRoomTypeDdown;

    @FindBy(xpath = "//input[@id='MaxAdultCount']")
    public WebElement addHotelroomMaxAdultCount;

    @FindBy(xpath = "//input[@id='MaxChildCount']")
    public WebElement addHotelroomMaxChildCount;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement addHotelroomSaveButton;

    @FindBy(xpath = "//div[.='HotelRoom was inserted successfully']")
    public WebElement addHotelroomSuccessfullySaveText;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement addHotelroomLastOk;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement addHotelroomCreateHotelroomText;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement addHotelCreateHotelText;

    @FindBy(xpath = "//span[text()='List Of Hotels']")
    public WebElement listOfHotelsText;

    @FindBy(xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement listOfHotelroomsText;

    @FindBy(xpath = "//span[text()='List Of Reservations']")
    public WebElement listOfReservationsText;

    @FindBy(xpath = "//span[text()='Add Room Reservation ']")
    public WebElement addRoomReservation;

    @FindBy(xpath = "//select[@id='IDUser']")
    public WebElement addRoomReservationSelectUserDdown;

    @FindBy(xpath = "//select[@id='IDHotelRoom']")
    public WebElement addRoomReservationSelectHotelroomDdown;

    @FindBy(xpath = "//input[@name='Price']")
    public WebElement addRoomReservationPrice;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement addRoomReservationSaveButton;

    @FindBy(xpath = "//div[text()='RoomReservation was inserted successfully']")
    public WebElement addRoomReservationSuccessfullySaveText;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement addRoomReservationLastOk;

    @FindBy(partialLinkText = "Room reservations")
    public WebElement roomReservation;

    @FindBy(xpath = "//input[@id='Approved']")
    public WebElement roomReservationApprovedButton;

    @FindBy(xpath = "//input[@id='ContactPhone']")
    public WebElement roomReservationPhone;

    @FindBy(xpath = "//label[text()='ContactNameSurname']")
    public WebElement roomReservationContactnameText;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement addRoomReservationCreateHRReservationText;

    @FindBy(xpath = "//span[text()='User Management']")
    public WebElement userManagement;

    @FindBy(partialLinkText = "User List")
    public WebElement userList;

    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement listOfUsersText;

    @FindBy(xpath = "//div[@class='actions']")
    public WebElement addUserButton;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement addUserUsernameBox;

    @FindBy(xpath = "//select[@id='IDCountry']")
    public WebElement addUserCountryDdown;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement addUserAddress;

    @FindBy(xpath = "//select[@id='IDRole']")
    public WebElement addUserRoleDdown;

    @FindBy(xpath = "(//div[@id='uniform-Approved'])[1]")
    public WebElement addUserYes;

    @FindBy(xpath = "(//div[@id='uniform-Approved'])[2]")
    public WebElement addUserNo;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement addUserSaveButton;

    @FindBy(xpath = "//label[text()='Country']")
    public WebElement asagiinmekicinClick;

    @FindBy(xpath = "//div[text()='User was inserted successfully']")
    public WebElement addUserSuccessfullySaveText;

    @FindBy(xpath = "//input[@id='WorkingSector']")
    public WebElement workingSector;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement addUserLastOk;

    @FindBy(xpath = "//li[@class='dropdown dropdown-user']")
    public WebElement usernameBoxForExit;

    @FindBy(xpath = "//a[text()=' Log out ']")
    public WebElement logOutbutton;

    @FindBy(tagName = "h3")
    public WebElement lastLogOutScreenLogInText;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement logInUsernameAfterLogOut;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement logInPasswordAfterLogOut;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement logInlogInButtonAfterLogOut;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement logInErrorAfterLogout;

    @FindBy(xpath = "//input[@id='NameSurname']")
    public WebElement contactFormNameSurname;

    @FindBy(xpath = "//input[@value='Send Message']")
    public WebElement contactFormSendMessage;

    @FindBy(xpath = "//div[@id='divMessageResult']")
    public WebElement contactFormMessageResult;

    @FindBy(xpath = "//tbody")
    public WebElement tBodyTumu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirListesi;

    @FindBy(xpath = "//tbody//tr[1]")
    public List<WebElement> ilkSatirElementleri;

    @FindBy(xpath = "//tbody/tr//td[4]")
    public List<WebElement> dorduncuSutunListesi;

    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//input[@name='IDHotel']")
    public WebElement hotelListIDHotel;

    @FindBy(xpath = "//select[@id='lkpGroups']")
    public WebElement hotelListIDGroupDDown;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement hotelListSearchButton;

    @FindBy(xpath = "(//div[@class='dataTables_info'])[1]")
    public WebElement aramaSonucu;

    @FindBy(xpath = "//button[text()='Clear']")
    public WebElement hotelListClearButton;

    @FindBy(xpath = "(//a[text()=' Details'])[1]")
    public WebElement detailsButton;

    @FindBy(xpath = "//button[@id='btnDelete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[text()='Would you like to continue?']")
    public WebElement silmekIstiyormusunText;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement okButton;

    @FindBy(xpath = "//a[text()='Photos']")
    public WebElement photosButton;

    @FindBy(xpath = "//a[text()='Select File ']")
    public WebElement selectFileButton;

    @FindBy(xpath = "//a[text()='Upload Files']")
    public WebElement uploadFileButton;

    @FindBy(xpath = "//a[text()='Properties']")
    public WebElement propertiesButton;

    @FindBy(xpath = "//select[@id='lkpBarcodeTypes']")
    public WebElement addPropertyTipDdown;

    @FindBy(xpath = "//input[@id='txtBarcodeCode']")
    public WebElement addPropertyCode;

    @FindBy(xpath = "//textarea[@id='txtBarcode']")
    public WebElement addPropertyValue;

    @FindBy(xpath = "(//button[text()='Save'])[2]")
    public WebElement addPropertySaveButton;

    @FindBy(xpath = "//div[text()='Value added']")
    public WebElement addPropertyValueAddedText;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addPropertyLastOkButton;

    @FindBy(xpath = "//a[text()=' Remove ']")
    public WebElement addPropertyRemoveButton;

    @FindBy(xpath = "//a[text()=' Update ']")
    public WebElement addPropertyUpdateButton;

    @FindBy(xpath = "//div[@id='datatable_barcodes_info']")
    public WebElement addPropertySonucYazisi;

    @FindBy(xpath = "//textarea[@class='form-control']")
    public WebElement addPropertyAfterSaveValue;

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement addPropertyAfterCode;

    @FindBy(xpath = "//div[text()='Value was updated Succesfully']")
    public WebElement addPropertySuccesfullyTextAfterUpdate;

    @FindBy(xpath = "//div[text()='Do you want to delete this barcode?']")
    public WebElement removeText;

    @FindBy(xpath = "//div[text()='Value was deleted Succesfully']")
    public WebElement removeTextSuccesfully;

    @FindBy(xpath = "//input[@name='IDHotelRoom']")
    public WebElement hotelRoomsID;

    @FindBy(xpath = "//select[@id='lkpHotels']")
    public WebElement hotelRoomsIDHotelDdown;

    @FindBy(xpath = "//input[@name='Code']")
    public WebElement hotelRoomsCode;

    @FindBy(xpath = "//select[@id='lkpGroupRoomTypes']")
    public WebElement hotelRoomsIDGroupRoomType;

    @FindBy(xpath = "//select[@name='IsAvailable']")
    public WebElement hotelRoomsIsAvailable;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement hotelRoomsSearchButton;

    @FindBy(xpath = "//button[text()='Clear']")
    public WebElement hotelRoomsClearButton;

    @FindBy(xpath = "(//td[@class='dataTables_empty'])[2]")
    public WebElement noDatainTableText;

    @FindBy(xpath = "//div[text()='Do you want to delete this barcode?']")
    public WebElement hotelRoomPropertySilmekIstiyormusun;

    @FindBy(xpath = "//input[@name='IDHotelReservation']")
    public WebElement reservationID;

    @FindBy(xpath = "//select[@id='lkpHotelRooms']")
    public WebElement reservationHotelRoom;

    @FindBy(xpath = "//select[@id='lkpUsers']")
    public WebElement reservationUser;

    @FindBy(xpath = "//input[@name='Price']")
    public WebElement reservationPrice;

    @FindBy(xpath = "(//select[@name='IsPaid'])[1]")
    public WebElement reservationApprovedDdown;

    @FindBy(xpath = "(//select[@name='IsPaid'])[2]")
    public WebElement reservationIsPaidDdown;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//button[text()='Clear']")
    public WebElement clearButton;

    @FindBy(xpath = "//label[text()='Notes']")
    public WebElement notesTextForClick;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement roomReservationEditSave;

    @FindBy(xpath = "(//div[text()='No records found to show'])[1]")
    public WebElement noRecordsFoundText;

    @FindBy(xpath = "//input[@name='IDUser']")
    public WebElement listOfUsersIduser;

    @FindBy(xpath = "//select[@name='Approved']")
    public WebElement listOfUsersApprovedDdown;

    @FindBy(xpath = "//select[@name='lkpRoles']")
    public WebElement listOfUsersRoleDdown;

    @FindBy(xpath = "(//a[text()=' Details'])[6]")
    public WebElement secilenUserDetailsButton;

    @FindBy(xpath = "//input[@id='PhoneNo']")
    public WebElement UserdataPhoneBox;

    @FindBy(xpath = "//input[@id='SSN']")
    public WebElement UserdataSSNbox;

    @FindBy(xpath = "//input[@id='DrivingLicense']")
    public WebElement UserdataDrivingLicenseBox;

    @FindBy(xpath = "//select[@id='IDCountry']")
    public WebElement UserDataCountryDdown;

    @FindBy(xpath = "//select[@id='IDState']")
    public WebElement UserDataStateDdown;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement UserDataaddressBox;

    @FindBy(xpath = "//select[@id='IDRole']")
    public WebElement UserDataRoleDdown;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement UserDataSaveButton;

    @FindBy(xpath = "//div[text()='User was updated successfully']")
    public WebElement UserDataSuccessUpdate;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement UserDataLastOk;

    @FindBy(xpath = "//a[text()='Files']")
    public WebElement filesButton;

    @FindBy(xpath = "//input[@id='fileInput']")
    public WebElement dosyalariSecButonu;

    @FindBy(xpath = "//button[@id='btnUpload']")
    public WebElement dosyayiYukleButonu;

    @FindBy(xpath = "//a[@id='tab_images_uploader_pickfiles']")
    public WebElement UserDataFileButton;

    @FindBy(xpath = "//a[@id='tab_images_uploader_uploadfiles']")
    public WebElement UserDataUploadButton;

    @FindBy(xpath = "//button[@id='btnExportTable']")
    public WebElement listeIndirmeButonu;

    @FindBy(xpath = "//select[@id='itemsExportTypes']")
    public WebElement indirmeSecenekleriDdown;

    @FindBy(xpath = "//div[@class='tools']/a[1]")
    public WebElement collapseButton;

    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("chotel_url"));
        LogIn_Page logIn_page=new LogIn_Page();
        logIn_page.firstLoginButton.click();
        logIn_page.usernameBox.sendKeys(ConfigReader.getProperty("chotel_valid_username"));
        logIn_page.passwordBox.sendKeys(ConfigReader.getProperty("chotel_valid_password"));
        logIn_page.loginButton.click();
    }

    public void listYazdir(List<WebElement> key){
        List<String> doneceklist = new ArrayList<>();
        for (WebElement w:key) {
            doneceklist.add(w.getText());

        }

        System.out.println(doneceklist);
    }

    public String tekliHucreGetir(int hucre){
        String xPath="(//tbody//tr//td)["+hucre+"]";
        String yazi=Driver.getDriver().findElement(By.xpath(xPath)).getText();
        return yazi;


    }

    public String hucreGetir(int satirNo, int sutunNo){
        String xPath="//tbody//tr["+satirNo+"]//td["+sutunNo+"]";
        String yazi=Driver.getDriver().findElement(By.xpath(xPath)).getText();
        return yazi;
    }

    public void switchWindow(){
        String ilkWindow=Driver.getDriver().getWindowHandle();
        Set<String> allWindow=Driver.getDriver().getWindowHandles();
        String ikinciWindow="";
        for (String each:allWindow) {
            if (!ilkWindow.equals(each)){
                ikinciWindow=each;
            }

        }
        Driver.getDriver().switchTo().window(ikinciWindow);

    }

}
