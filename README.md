# CS 320 Portfolio Submission

This repository contains selected artifacts from CS 320: Software Testing, Automation, and Quality Assurance. These files demonstrate my ability to design secure software components, implement unit tests, and reflect on testing strategies and development practices.

---

## Project One: Contact Service

**Files Included:**
- Contact.java  
- ContactService.java  
- ContactTest.java  
- ContactServiceTest.java  

**Overview:**  
The Contact Service project showcases a modular contact management system built with secure input validation and defensive programming. The `Contact` class enforces strict constraints on all fields to prevent invalid data and potential injection risks. The `ContactService` class provides methods for adding, updating, and deleting contacts while preserving data integrity. Unit tests written with JUnit validate object creation, field constraints, and edge cases to ensure secure and predictable behavior.

---

## Project Two: Summary and Reflections

**File Included:**
- ProjectTwo_Reflections.pdf

**Overview:**  
This report reflects on the development and testing of Task and Appointment services. It discusses challenges with dependency setup, the importance of reproducible environments, and future plans to integrate CI tools and coverage metrics. Feedback from this project highlighted the need for deeper alignment between tests and requirements, more explicit examples of technically sound and efficient code, and stronger justification of testing strategies. These insights have shaped my approach to future projects, where I will prioritize clarity, reproducibility, and disciplined coding practices.

---

## Journal Questions

### How can I ensure that my code, program, or software is functional and secure?

I ensure functionality and security by applying strict input validation, using immutable objects, and writing comprehensive unit tests to catch edge cases and logic errors. In Project One, I enforced constraints on all fields—such as exact phone number formats and maximum string lengths—to prevent invalid data and injection risks. I also use exception handling to guard against null values and unexpected input. I plan to improve future submissions by including more explicit examples of these practices and integrating coverage tools like JaCoCo to quantify test effectiveness.

### How do I interpret user needs and incorporate them into a program?

I begin by analyzing functional requirements and translating them into testable behaviors. For example, the ContactService methods reflect real-world operations like updating a phone number or deleting a contact, while preserving data integrity. In Project Two, I structured tests to validate these behaviors, though feedback indicated I could strengthen alignment by referencing specific requirements more directly. Moving forward, I’ll map each test to its corresponding requirement and document that linkage clearly to improve traceability and reviewer clarity.

### How do I approach designing software?

My design approach emphasizes modularity, clarity, and defensive programming. I break down functionality into focused classes and methods, validate inputs rigorously, and use consistent patterns to make the code maintainable and testable. I also reflect on the implications of each design choice—such as the trade-offs between immutability and flexibility. Project Two helped me recognize the importance of reproducible environments and disciplined packaging, which I’ll address by adopting Maven libraries, CI pipelines, and automated coverage tools to ensure consistent quality and evaluation readiness.

---

## Journal Reflection

Throughout CS 320, I’ve developed a deeper understanding of how testing strategies shape software quality and reliability. In Project One, I applied defensive programming and validation logic to build a secure Contact Service, supported by unit tests that covered both valid and invalid input scenarios. This reinforced the importance of anticipating edge cases and enforcing constraints to prevent runtime failures.

Project Two challenged me to think beyond code correctness and consider the infrastructure that supports testing—such as dependency management, reproducibility, and packaging. Although my initial test suite was non-executable due to a missing JUnit dependency, I learned the value of complete, runnable submissions and the role of build tools like Maven in supporting evaluation. Feedback from this project highlighted areas for growth, including deeper alignment between tests and requirements, more explicit examples of efficient and technically sound code, and stronger justification of testing strategies.

These experiences have shaped my commitment to disciplined development practices. I now prioritize clarity in documentation, traceability between requirements and tests, and the use of automated tools to measure coverage and enforce standards. As I continue building my portfolio, I aim to deliver secure, maintainable software that reflects both technical rigor and thoughtful reflection.
