package CA_2.Models;

import CA_2.Models.Department.Department;

/**
 * PersonSearchResult holds data about the result of a person search operation within the company.
 *
 * This class bundles information about a person,
 * the company they are associated with,
 * and their specific department.
 * This structure allows for easier tracking and display of person search results.
 *
 */
public class PersonSearchResult {
    public Person person;
    public Company company;
    public Department department;
}
