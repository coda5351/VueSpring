# API Configuration Guide

## Environment Variables

The application uses environment-specific configuration files for API settings:

- **Development**: `.env.development` - Used when running `npm run dev`
- **Production**: `.env.production` - Used when running `npm run build`

### API Base URL Configuration

```env
# Development
VITE_API_BASE_URL=http://localhost:8080/api

# Production
VITE_API_BASE_URL=https://api.vuespring.com/api
```

## API Utility Usage

All API calls should use the centralized API utility located at `src/utils/api.ts`.

### Basic Usage

```typescript
import { apiFetch, api, getApiUrl } from '@/utils/api'

// Using apiFetch directly
const response = await apiFetch('/users', {
  method: 'GET',
  headers: {
    'Authorization': `Bearer ${token}`
  }
})

// Using convenience methods
const response = await api.get('/users', {
  headers: { 'Authorization': `Bearer ${token}` }
})

const response = await api.post('/users', { 
  name: 'John Doe',
  email: 'john@example.com'
}, {
  headers: { 'Authorization': `Bearer ${token}` }
})
```

### Available Methods

- **`api.get(endpoint, options)`** - GET request
- **`api.post(endpoint, data, options)`** - POST request with JSON body
- **`api.put(endpoint, data, options)`** - PUT request with JSON body
- **`api.patch(endpoint, data, options)`** - PATCH request with JSON body
- **`api.delete(endpoint, options)`** - DELETE request

### Features

1. **Automatic Base URL**: All requests automatically use `VITE_API_BASE_URL`
2. **Request Timeout**: Configurable via `VITE_API_TIMEOUT` (default: 30000ms)
3. **JSON Headers**: Content-Type is automatically set to `application/json`
4. **Timeout Handling**: Requests abort after the configured timeout period
5. **Type Safety**: Full TypeScript support with proper typing

### Getting Full URLs

If you need the complete URL (e.g., for constructing URL objects):

```typescript
import { getApiUrl } from '@/utils/api'

const fullUrl = getApiUrl('/users')
// Returns: http://localhost:8080/api/users (in development)

// For URL objects with query params
const url = new URL(getApiUrl('/users'))
url.searchParams.append('page', '1')
```

## Migration from Direct Fetch

Before:
```typescript
const response = await fetch('http://localhost:8080/api/users', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(data)
})
```

After:
```typescript
import { api } from '@/utils/api'

const response = await api.post('/users', data)
// OR
import { apiFetch } from '@/utils/api'

const response = await apiFetch('/users', {
  method: 'POST',
  body: JSON.stringify(data)
})
```

## Benefits

1. **Centralized Configuration**: Change API base URL in one place
2. **Environment-Specific**: Automatically uses correct endpoint per environment
3. **Consistent Error Handling**: Uniform timeout and error management
4. **Cleaner Code**: Less boilerplate in each API call
5. **Type Safety**: Better TypeScript support and autocomplete
