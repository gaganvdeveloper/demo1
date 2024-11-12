<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fc;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        
        h1 {
            color: #333;
            font-size: 2.5rem;
            margin-bottom: 20px;
        }

        .form-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            box-sizing: border-box;
        }

        .form-container input {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1rem;
            box-sizing: border-box;
        }

        .form-container input:focus {
            border-color: #4CAF50;
            outline: none;
        }

        .form-container button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 12px;
            width: 100%;
            border-radius: 5px;
            font-size: 1.1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-container button:hover {
            background-color: #45a049;
        }

        .form-container input::placeholder {
            color: #888;
        }

        .form-container .form-title {
            text-align: center;
            margin-bottom: 30px;
        }

        .form-container label {
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
            color: #333;
        }

        .form-container .form-footer {
            text-align: center;
            margin-top: 20px;
            font-size: 0.9rem;
        }

        .form-container .form-footer a {
            color: #4CAF50;
            text-decoration: none;
        }

        .form-container .form-footer a:hover {
            text-decoration: underline;
        }

    </style>
</head>
<body>
    <div class="form-container">
        <h1 class="form-title">Register Here</h1>
        <form action="reg">
            <label for="id">ID</label>
            <input type="number" id="id" name="id" placeholder="Enter Id" required>

            <label for="name">Name</label>
            <input type="text" id="name" name="name" placeholder="Enter Name" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" placeholder="Enter Email" required>

            <label for="phone">Phone Number</label>
            <input type="tel" id="phone" name="phone" placeholder="Enter Phone Number" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter Password" required>

            <button type="submit">Register</button>
        </form>
        <div class="form-footer">
            <p>Already have an account? <a href="#">Login here</a></p>
        </div>
    </div>
</body>
</html>
