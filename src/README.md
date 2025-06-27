# Système de Réservation d’Hôtel en Java

## Description

Ce projet est une application Java simple permettant de gérer les réservations d’un hôtel.  
Il permet de créer des réservations avec gestion des utilisateurs, types de chambres, dates d’arrivée et départ, et calcul du prix total.

Le projet a été développé dans le cadre d’un test technique Java pour renforcer les compétences en POO, gestion des dates et utilisation d’énumérations.

## Fonctionnalités

- Création de réservations avec :
    - Identification de l’utilisateur
    - Choix du type de chambre (STANDARD, JUNIOR, SUITE)
    - Gestion des dates d’arrivée et de départ
    - Calcul automatique du prix total
- Gestion des types de chambres avec énumération
- Validation des dates (exemple : la date de départ doit être après la date d’arrivée)
- Commentaires dans le code pour faciliter la compréhension
- Utilisation de la classe `LocalDate` pour la gestion des dates


## Design Questions (Bonus)



### 1. Is it recommended to put all functions inside a single service class?

For this simple project, grouping all functions in one `Service` class is acceptable and makes centralized data management easier.  
However, for larger and more complex projects, this approach is not recommended as it leads to a monolithic class that is hard to maintain and test.  
It is better to separate responsibilities into multiple dedicated services (user management, room management, booking management), following the Single Responsibility Principle (SRP).

### 2. In this design, the `setRoom(..)` function should not affect previous bookings. What alternative approach do you recommend?

A recommended approach is to treat bookings as immutable once created.  
Instead of modifying the room of an existing booking via `setRoom(..)`, it is better to create a new booking with the updated room.  
This avoids side effects, preserves booking history, and ensures data integrity.


