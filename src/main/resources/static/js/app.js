/**
 * Placement Preparation Tracker - Frontend JavaScript
 * 
 * Interacts with Spring Boot REST API endpoints:
 * - GET    /api/tasks      -> Load all tasks
 * - POST   /api/tasks      -> Add a new task
 * - DELETE /api/tasks/{id} -> Delete a task
 */

// Base URL for the tasks REST API
const API_BASE_URL = '/api/tasks';

// DOM Elements
const taskForm = document.getElementById('task-form');
const taskTableBody = document.getElementById('task-table-body');
const emptyState = document.getElementById('empty-state');
const taskCountBadge = document.getElementById('task-count');
const notificationBanner = document.getElementById('notification-banner');

// 1. Load tasks automatically when the page finishes loading
document.addEventListener('DOMContentLoaded', () => {
    fetchTasks();
});

// 2. Form submission handler: Adds a new task
taskForm.addEventListener('submit', async (event) => {
    event.preventDefault(); // Prevents full-page reload on submit

    // Extract values from form input fields
    const taskName = document.getElementById('taskName').value.trim();
    const topic = document.getElementById('topic').value;
    const status = document.getElementById('status').value;

    const newTask = {
        taskName: taskName,
        topic: topic,
        status: status
    };

    try {
        // Send HTTP POST request with JSON body
        const response = await fetch(API_BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newTask)
        });

        if (!response.ok) {
            throw new Error(`Server responded with status: ${response.status}`);
        }

        // Show success notification and reset form
        showNotification('✅ Task added successfully!', 'success');
        taskForm.reset();

        // Refresh task list from the database
        fetchTasks();

    } catch (error) {
        console.error('Error adding task:', error);
        showNotification('⚠️ Could not save task. Please ensure the backend is running.', 'error');
    }
});

// 3. Fetch all tasks from backend (GET /api/tasks)
async function fetchTasks() {
    try {
        const response = await fetch(API_BASE_URL);

        if (!response.ok) {
            throw new Error(`Failed to fetch tasks: ${response.status}`);
        }

        const tasks = await response.json();
        renderTasks(tasks);

    } catch (error) {
        console.error('Error connecting to backend:', error);
        showNotification('⚠️ Unable to connect to backend server. Please make sure Spring Boot is running.', 'error');
        renderTasks([]); // Render empty table if backend is offline
    }
}

// 4. Render tasks into the HTML table
function renderTasks(tasks) {
    // Clear existing table rows
    taskTableBody.innerHTML = '';

    // Update the task counter badge
    taskCountBadge.textContent = `${tasks.length} Task${tasks.length === 1 ? '' : 's'}`;

    // Toggle empty state message if there are no tasks
    if (tasks.length === 0) {
        emptyState.classList.remove('hidden');
        return;
    } else {
        emptyState.classList.add('hidden');
    }

    // Build table rows dynamically
    tasks.forEach(task => {
        const row = document.createElement('tr');

        // Determine CSS class for the status badge
        let statusClass = 'status-pending';
        if (task.status === 'In Progress') {
            statusClass = 'status-in-progress';
        } else if (task.status === 'Completed') {
            statusClass = 'status-completed';
        }

        row.innerHTML = `
            <td>#${task.id}</td>
            <td><strong>${escapeHtml(task.taskName)}</strong></td>
            <td><span class="badge-topic">${escapeHtml(task.topic)}</span></td>
            <td><span class="badge-status ${statusClass}">${escapeHtml(task.status)}</span></td>
            <td>
                <button class="btn btn-danger" onclick="deleteTask(${task.id})">🗑️ Delete</button>
            </td>
        `;

        taskTableBody.appendChild(row);
    });
}

// 5. Delete a task by ID (DELETE /api/tasks/{id})
async function deleteTask(id) {
    // Confirmation dialog for beginner-friendly safety
    const confirmed = confirm(`Are you sure you want to delete task #${id}?`);
    if (!confirmed) {
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/${id}`, {
            method: 'DELETE'
        });

        if (!response.ok) {
            throw new Error(`Failed to delete task: ${response.status}`);
        }

        showNotification(`🗑️ Task #${id} deleted successfully.`, 'success');
        // Refresh the task list from database
        fetchTasks();

    } catch (error) {
        console.error('Error deleting task:', error);
        showNotification('⚠️ Could not delete task. Please check if the backend is running.', 'error');
    }
}

// 6. Helper: Display temporary notification banner
function showNotification(message, type) {
    notificationBanner.textContent = message;
    notificationBanner.className = `notification ${type}`;
    notificationBanner.classList.remove('hidden');

    // Automatically hide after 4 seconds
    setTimeout(() => {
        notificationBanner.classList.add('hidden');
    }, 4000);
}

// 7. Helper: Sanitize text to prevent HTML injection
function escapeHtml(text) {
    if (!text) return '';
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}
