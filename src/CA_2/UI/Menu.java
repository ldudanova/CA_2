package CA_2.UI;

import CA_2.Models.*;
import CA_2.Models.Developer.Developer;
import CA_2.Models.Manager.Manager;
import CA_2.Models.Menu.*;
import CA_2.Utils.Helper;
import CA_2.Utils.SortAndSearchOperations;
import CA_2.Utils.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static CA_2.Utils.InputUtilities.*;
import static CA_2.Utils.Helper.getRandomOrGeneratedCompany;

/**
 * Class for displaying a menu and asking the user for their choice.
 */
public class Menu {
    /**
     * Method for starting a menu loop, asking for user input, and performing actions
     */
    public static void showMenu() {

        // Flag to control the exit from the menu loop
        boolean needToExit = false;

        // Main menu loop that continues until 'needToExit' is set to true
        do {
            // Prompting the user to select an action from the main menu
            menuOptions action =
                    selectFromList("\n============ Main menu ===============\n",
                            menuOptions.class);

            // Evaluating the action selected by the user
            switch (action) {
                case CREATE_COMPANY: {
                    selectWayToCreateNewCompanyOptions selectWayToCreateNewCompanyOption =
                            selectFromList("\nSelect the way to create a name for a new company: ",
                                    selectWayToCreateNewCompanyOptions.class);
                    switch (selectWayToCreateNewCompanyOption) {
                        case INPUT: {
                            String companyName =
                                    askUserForText("\nEnter the name for your company: ");
                            Company.create(companyName);
                            break;
                        }
                        case GENERATE: {
                            Company.create(Company.generateName());
                        }
                    }
                    break;
                }

                case SHOW_COMPANIES_LIST: {
                    // Print all companies
                    Printer.printCompanyNames(Store.companies);
                    break;
                }

                // If the "SORT" option is selected
                case SORT: {
                    // Asking for sort direction
                    sortingDirection sortingDirection =
                            selectFromList("\nSelect order direction:", sortingDirection.class);

                    // Create new sorted list of people
                    ArrayList<Person> sortedPeople =
                            SortAndSearchOperations.recursiveInsertionSort(Store.people, sortingDirection);

                    // Print top 20 items of sorted list
                    Printer.printPeople(sortedPeople, 20);

                    break;
                }

                // If the "SEARCH PEARSON" option is selected
                case SEARCH_PERSON: {
                    // Asking the user for a search input (could be first name, last name, or both)
                    String searchString =
                            askUserForText("Enter first name, last name or both for searching: ");

                    List<PersonSearchResult> searchResult =
                            SortAndSearchOperations.findEmployeesDataByName(searchString);

                    // Checking if any results were found and displaying them; otherwise, notify no results were found
                    if (searchResult.isEmpty()) {
                        System.out.println("No results were found for your request");
                    } else {
                        System.out.println("Search result: ");
                        searchResult.forEach(info -> {
                            System.out.println("Employee: " + info.person);
                            System.out.println("Department: " + info.department);
                            System.out.println("Company: " + info.company);
                            System.out.println("---------");
                        });
                    }

                    break;
                }

                case SEARCH_COMPANY: {
                    String searchString =
                            askUserForText("Enter company name for searching: ");
                    Company searchResult =
                            SortAndSearchOperations.findCompanyByName(searchString);
                    if (searchResult == null) {
                        System.out.println("No results were found for your request");
                    } else {
                        searchResult.print(1, "  ");
                    }
                    break;
                }

                // Third option is selected
                case USER_INPUT: {
                    //
                    if (Store.companies.isEmpty()) {
                        System.out.println("\nThere's no companies to add a new object.");
                        System.out.println("\nAdd a company first.");
                        userWayToAddANewCompany selectedOption =
                                selectFromList("Select the way to add a new company: ",
                                        userWayToAddANewCompany.class);
                        switch (selectedOption) {
                            case CUSTOM: {
                                String companyName =
                                        askUserForText("\nEnter the name for your company: ");
                                Company.create(companyName);
                                break;
                            }
                            case GENERATE: {
                                Store.companies.add(Company.generate());
                                break;
                            }
                        }
                    }
                    Company selectedCompany = selectFromList("Select a company where to add a new object: ",
                            Store.companies.toArray(new Company[0]), Company::getName);
                    System.out.println("selectedCompany: " + selectedCompany.name);

                    // Asking for type of object to create
                    userInputOptions inputOption =
                            selectFromList("What type of object do you want to add?",
                                    userInputOptions.class);

                    switch (inputOption) {
                        // Creating developer
                        case DEVELOPER: {
                            Helper.addDeveloper(selectedCompany);
                            break;
                        }
                        // Creating manager
                        case MANAGER: {
                            Helper.addManager(selectedCompany);
                            break;
                        }
                        // Creating department
                        case DEPARTMENT: {
                            Helper.addDepartment(selectedCompany);
                            break;
                        }
                    }
                    break;
                }

                // Fourth option is selected
                case GENERATE: {
                    // Asking for type of object to generate
                    userGenerateOptions userGenerateOption =
                            selectFromList("What type of object do you want to generate?",
                                    userGenerateOptions.class);
                    switch (userGenerateOption) {
                        // Generating employee
                        case DEVELOPER: {
                            Company randomCompany;
                            if (Store.companies.isEmpty()) {
                                Store.companies.add(Company.generate());
                            }
                            randomCompany =
                                    Store.companies
                                            .get(new Random()
                                                    .nextInt(Store.companies.size()));
                            Developer developer =
                                    Helper.generateDeveloperAndAddDeveloperToITDepartment(randomCompany);
                            Store.people.add(developer);
                            System.out.println("Developer " + developer + " has been added to " + randomCompany.getName());
                            break;
                        }
                        // Generating manager
                        case MANAGER: {
                            Company randomCompany;
                            randomCompany = getRandomOrGeneratedCompany();
                            Manager manager = Helper.generateManagerAndAddManagerToDepartment(randomCompany);
                            Store.people.add(manager);
                            System.out.println("Manager " + manager + " has been added to " + randomCompany.getName());
                            break;
                        }
                        // Generating office employee
                        case OFFICE_EMPLOYEE: {
                            Company randomCompany;
                            randomCompany = getRandomOrGeneratedCompany();
                            OfficeEmployee officeEmployee =
                                    Helper.generateOfficeEmployeeAndAddOfficeEmployeeToNonITDepartment(randomCompany);
                            Store.people.add(officeEmployee);
                            System.out.println("Office employee " + officeEmployee + " has been added to " + randomCompany.getName());
                            break;
                        }
                        // Generating company
                        case COMPANY: {
                            Company newCompany = Company.generate();
                            Store.companies.add(newCompany);
                            System.out.println("The company has been added: " + newCompany.name);
                            break;
                        }
                    }
                    break;
                }

                case PRINT: {
                    // Asking for type of objects to print
                    printingType printingOption =
                            selectFromList("What type of object do you want to print?",
                                    printingType.class);

                    switch (printingOption) {
                        //
                        case ALL_COMPANIES: {
                            Printer.printCompaniesData(Store.companies);
                            break;
                        }
                        // Printing all data from Store.people
                        case ALL_PEOPLE: {
                            System.out.println("All people:");
                            Printer.printPeople(Store.people, Store.people.size());
                            break;
                        }
                    }

                    break;
                }

                // If the "EXIT" option is selected, set the exit flag to true to terminate the menu loop
                case EXIT: {
                    needToExit = true;
                    break;
                }
            }

            // Repeat the loop as long as "needToExit" is false
        } while (!needToExit);
    }
}
