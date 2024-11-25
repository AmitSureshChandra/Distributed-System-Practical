function updateGreeting() {
    const username = document.getElementById('username').value;
    const greeting = document.getElementById('greeting');
    greeting.textContent = `Hello, ${username}!`;
}