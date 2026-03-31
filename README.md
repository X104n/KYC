# KYC - Know Your Customer

A terminal-based KYC (Know Your Customer) management system for storing, searching, and managing customer records with compliance tracking.

## Features

- **Role-based access**: Admin and read-only user roles
- **Customer management**: Add and search customer records
- **PEP tracking**: Flag Politically Exposed Persons for compliance
- **Flexible search**: Search by ID, name, or country of residence
- **Dynamic database**: Auto-expanding ID range as the database grows

## Requirements

- Java Development Kit (JDK)

## Getting Started

**Compile:**
```bash
cd src
javac Customer/Person.java Customer/ICustomer.java Database/*.java KYC_Terminal.java
```

**Run:**
```bash
java KYC_Terminal
```

You will be prompted to log in as admin or regular user.

## Usage

### Commands

| Key | Action |
|-----|--------|
| `c` | Show available commands |
| `q` | Quit |

### Admin commands

| Command | Description |
|---------|-------------|
| `add`   | Add a new customer |
| `name`  | Search by name |
| `id`    | Search by ID |
| `country` | Search by country |
| `print` | Print all customers |

### User commands (read-only)

| Command | Description |
|---------|-------------|
| `name`  | Search by name |
| `id`    | Search by ID |
| `country` | Search by country |
| `print` | Print all customers |

## Project Structure

```
src/
├── KYC_Terminal.java       # Main entry point and CLI
├── Customer/
│   ├── ICustomer.java      # Customer interface
│   └── Person.java         # Customer data model
└── Database/
    ├── IDataBase.java       # Database interface
    └── DataBasePerson.java  # In-memory HashMap database
```

## Data Model

Each customer record contains:

**Mandatory fields:**
- Name
- Date of birth (dd-mm-yyyy)
- Country of residence
- PEP status (Politically Exposed Person)

**Optional fields (WIP):**
- Aliases
- Sanctions list entries
- Phone numbers
- Email addresses

## Notes

- All data is stored in-memory; there is no persistence between sessions.
- The database ships with two sample records on startup.
