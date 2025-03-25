function borrowBook() {
    const user = document.getElementById("username").value;
    const type = document.getElementById("usertype").value;
    const book = document.getElementById("bookname").value;
  
    document.getElementById("message").innerText =
      `${type} ${user} wants to borrow '${book}' (Simulated - backend in Java)`;
  }
  
  function returnBook() {
    const user = document.getElementById("username").value;
    const type = document.getElementById("usertype").value;
    const book = document.getElementById("bookname").value;
  
    document.getElementById("message").innerText =
      `${type} ${user} returned '${book}' (Simulated - backend in Java)`;
  }
  