import axios from 'axios';

const API_BASE_URL = '/rental-store';

export const getAllVideoGames = async () => {
    try {
        const response = await axios.get(`${API_BASE_URL}/videogames`);
        return response.data;
    } catch (error) {
        console.error('Error fetching video games:', error);
        throw error;
    }
};

export const rentGame = async (customerId, gameTitle) => {
    const rentGameRequest = {
        customerId,
        gameTitle,
    };

    const response = await await fetch(`${API_BASE_URL}/rent-game`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(rentGameRequest),
    });

    const result = await response.json();

    if (result === "its done!") {
        return { success: true, message: result };
    } else {
        return { success: false, message: result };
    }
};

export const returnGame = async (name, customerID, title, givenrentalID) => {
    const returnGameRequest = {
        name,
        customerID,
        title,
        givenrentalID,
    };
    
    const response = await fetch(`${API_BASE_URL}/return-game`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(returnGameRequest),
    });

    const result = await response.json();

    if (result === "its done!") {
        return { success: true, message: result };
    } else {
        return { success: false, message: result };
    }
};

export const registerCustomer = async (name) => {
    const response = await axios.post(`${API_BASE_URL}/register-customer`, name, {
        headers: {
            'Content-Type': 'text/plain',
        }
    });
    return response.data;
};

export const getAllCustomers = async () => {
    const response = await axios.get(`${API_BASE_URL}/customers`);
    return response.data;
};

export const getMyRentals = async (customerID) => {
try {
    const response = await axios.get(`${API_BASE_URL}/my-rentals`);
    params: {
        customerID
    }
    return response.data;
} catch (error) {
    console.error('Error fetching rentals:', error);
    throw error;
}
};