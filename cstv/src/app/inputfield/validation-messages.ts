export const validation_messages = {
    'username': [
        { type: 'required', message: 'Username is required.' },
        { type: 'minlength', message: 'Username must be at least 7 characters long.' },
        { type: 'maxlength', message: 'Username cannot be more than 25 characters long.' },
    ],
    'password': [
        { type: 'required', message: 'Password is required.' },
        { type: 'minlength', message: 'Password must be at least 7 characters long.' },
    ]
}