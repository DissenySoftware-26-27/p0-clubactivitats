package controller;

import model.Activity;
import model.User;
import model.VirtualCard;
import model.exceptions.InsufficientCreditException;
import model.exceptions.TopUpLimitReachedException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    private HashMap<String, User> users;
    private HashMap<String, VirtualCard> virtualCards;
    private Map<String, Activity> activityList;

    public Controller() {
        activityList= new HashMap<>();
        users = new HashMap<>();
        virtualCards = new HashMap<>();
        iniActivitatsList();
    }

    public void initializeUsers()  {
        users.put("ajaleo@gmail.com", new User("ajaleo@gmail.com", "ajaleoPassw7"));
        users.put("dtomacal@yahoo.cat", new User("dtomacal@yahoo.cat", "Qwertyft5"));
    }

    public void iniActivitatsList() {
        activityList.put("Museu Miró", new Activity("Museu Miró"));
        activityList.put("La Foradada", new Activity ("La Foradada"));
        activityList.put("El camí des Correu", new Activity("El camí des Correu"));
    }

    // Metodes relacionats amb usuaris

    public String signUp(String username, String password) {
        if (users.containsKey(username)) {
            return "Email already registered - please log in";
        } else if (!isValidEmail(username)) {
            return "Invalid email format";
        } else if (!isStrongPassword(password)) {
            return  "Weak password - must be at least 12 characters with 1 capital letter and 1 number";
        } else {
            users.put(username, new User(username, password));
            return "Registration successful";
        }
    }

    public boolean isStrongPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
    public boolean isValidEmail(String correu) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correu);
        return matcher.find();
    }



    public void removeUser(String email) {
        users.remove(email);
    }

    public void addUser(String arg0, String password) {
        // Inicialitzem un usuari temporal amb el nom d'usuari i contrasenya  passats per paràmetre
        if (!users.containsKey(arg0)) {
            users.put(arg0, new User(arg0, password));
        }
    }

    // Metodes relacionats amb virtual cards

    public String createNewCardForUser(String username) {
        if (virtualCards.containsKey(username))
            return "The user already has a virtual card";

        VirtualCard newVirtualCard = new VirtualCard(username, 0);
        virtualCards.put(username, newVirtualCard);
        return "Successfully created virtual card";
    }

    public String topUpVirtualCard(String username, double amount) {

        VirtualCard existingVirtualCard = virtualCards.get(username);
        try {
            existingVirtualCard.topUp(amount);
        } catch (TopUpLimitReachedException e) {
            return MessagesEN.translate(e);
        }

        return "Successful top up";
    }

    public String withdrawVirtualCard(String username, double amount) {

        VirtualCard existingVirtualCard = virtualCards.get(username);
        try {
            existingVirtualCard.withdraw(amount);
        } catch (InsufficientCreditException e) {
            return "The virtual card has not enough credit";
        }

        return "Successful withdrawn";
    }

    // Metodes relacionats amb activitats
    public List<String> listActivities() {
        List<String> activities = new ArrayList<>();

        for (String activity : activityList.keySet()) {
                activities.add(activity);
        }
        Collections.sort(activities);
        return activities;
    }

    public void clearActivities() {
        activityList.clear();
    }

    public void addAllActivities(List<String> inputActivities) {
        for (String activity : inputActivities) {
            activityList.put(activity, new Activity(activity));
        }
    }
}
