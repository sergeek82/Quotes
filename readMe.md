# Quote app

### Reference Documentation
Method endpoints:

* POST [http://localhost:8090/quote]() Add a quote
* POST [http://localhost:8090/user]() Add user
* POST [http://localhost:8090/vote/{quoteId}]() up vote a quote
* GET [http://localhost:8090/quote/best]() get 10 best quotes
* GET [http://localhost:8090/quote/worst]() get 10 worst quotes
* GET [http://localhost:8090/quote/{id}]() get a quote by id
* GET [http://localhost:8090/{quoteId}/activity]() get a quote activity
* PATCH [http://localhost:8090/quote/{id}]() edit a quote
* DELETE [http://localhost:8090/quote/{id}]() remove a quote
* DELETE [http://localhost:8090/vote/{quoteId}]() down vote a quote

### Guides
>The project contains a [docker-compose](docker-compose.yml) file that located at the root directory and might be 
> used to 
> run an application.


> - The API  allow:
>> * Creation of a user account (deletion and other CRUD operations not requested).
User properties are name, email, password and date of creation;
> 
>> * Addition, viewing (including a method to get a random quote), modification, and deletion of quotes (real deletion 
 from the database, not just via an archive flag). Quote properties include content, date of creation / update, link to user who posted it, link to votes;
>
>> * Voting on quotes (either upvote or downvote);
view of the top and worse 10 quotes, the details of each quote, and ideally a graph of the evolution of the votes.
