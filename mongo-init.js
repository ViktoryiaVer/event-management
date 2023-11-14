const conn = new Mongo();

const db = conn.getDB("eventManagementDb");

db.createCollection("events");

db.events.insertMany([{
    "_id": "GOODBY1",
    "name": "Goodby event",
    "description": "Participants will have a possibility to give their feedback and ask questions",
    "theme": "Goodby",
    "duration_in_minutes": 60,
    "participants": [
        {
            "first_name": "Katty",
            "last_name": "Pops",
            "email": "pops_katty@gmail.com"
        },
        {
            "first_name": "Oliver",
            "last_name": "Kaster",
            "email": "oliver_kaster@gmail.com"
        },
        {
            "first_name": "testmann",
            "last_name": "test",
            "email": "test@mail.ru"
        }
    ],
    "_class": "com.eventcompany.eventmanagement.model.entity.Event"
},
    {
        "_id": "DAILY1",
        "name": "Daily meeting 1",
        "description": "First daily meeting",
        "theme": "Seminar",
        "duration_in_minutes": 60,
        "participants": [
            {
                "first_name": "Katty",
                "last_name": "Pops",
                "email": "pops_katty@gmail.com"
            },
            {
                "first_name": "Oliver",
                "last_name": "Kaster",
                "email": "oliver_kaster@gmail.com"
            },
            {
                "first_name": "Mary",
                "last_name": "Maximer",
                "email": "maximer_mary@gmail.com"
            },
            {
                "first_name": "John",
                "last_name": "Doe",
                "email": "john_doe@gmail.com"
            },
            {
                "first_name": "dsf",
                "last_name": "sdfsdf",
                "email": "sdfsdf@mail.ru"
            }
        ],
        "_class": "com.eventcompany.eventmanagement.model.entity.Event"
    },
    {
        "_id": "IMPORTANT1",
        "name": "Important meeting 1",
        "description": "First important meeting for all staff",
        "theme": "Important meeting",
        "duration_in_minutes": 30,
        "participants": [
            {
                "first_name": "Katty",
                "last_name": "Pops",
                "email": "pops_katty@gmail.com"
            },
            {
                "first_name": "Oliver",
                "last_name": "Kaster",
                "email": "oliver_kaster@gmail.com"
            },
            {
                "first_name": "Mary",
                "last_name": "Maximer",
                "email": "maximer_mary@gmail.com"
            },
            {
                "first_name": "John",
                "last_name": "Doe",
                "email": "john_doe@gmail.com"
            }
        ],
        "_class": "com.eventcompany.eventmanagement.model.entity.Event"
    },
    {
        "_id": "SEM1",
        "name": "Seminar discussion",
        "description": "This is an event for seminar discussion",
        "theme": "Seminar",
        "duration_in_minutes": 60,
        "participants": [],
        "_class": "com.eventcompany.eventmanagement.model.entity.Event"
    },
]);