import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Ollama from './ollama/ollama';

const AiRoutes = () => (
  <div>
    <ErrorBoundaryRoutes>
      <Route path="ollama" element={<Ollama />} />
    </ErrorBoundaryRoutes>
  </div>
);

export default AiRoutes;
